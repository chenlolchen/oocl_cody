--秒杀执行存储过程
DELIMITER $$ -- console ; 转换为$$
--定义存储过程
--参数：in 输入参数；out输出参数
CREATE PROCEDURE 'seckill'.'execute_seckill'(
  IN v_seckill_id bigint,
  IN v_phone bigint,
  IN v_kill_time TIMESTAMP ,
  out r_result INT
  )
  BEGIN
    DECLARE insert_count INT DEFAULT 0;
    START TRANSACTION ;
    INSERT ignore INTO success_killed (seckill_id,user_phone,create_time)
    VALUES (v_seckill_id,v_phone,v_kill_time);
    SELECT ROW_COUNT() INTO insert_count;
    IF(insert_count < 0) THEN
      ROLLBACK;
      SET r_result = -1;
    ELSEIF(insert_count < 0) THEN
      ROLLBACK;
      SET r_result = -2;
    ELSE
      UPDATE seckill
      SET NUMBER = NUMBER - 1
      WHERE seckill_id = v_seckill_id
        AND end_time > v_kill_time
        AND start_time < v_kill_time
        AND NUMBER > 0;
      SELECT ROW_COUNT() INTO insert_count;
      IF(insert_count = 0) THEN
        ROLLBACK;
        SET r_result = 0;
      ELSEIF (insert_count < 0) THEN
        ROLLBACK;
        SET r_result = -2;
      ELSE
        COMMIT;
        SET r_result = 1;
      END IF;
    END IF;
    END;
  $$
  --存储过程定义结束

  DELIMITER;
  SET @r_result=-3;
  call execute_seckill(1003,13502178891,now(),@r_result);

  -- 获取结果
  SELECT @r_result;
