-- 求工资高于公司平均工资的员工
select e1.ename,e1.sal from emp e1 where sal > (select avg(sal) from emp);

-- 求工资最高的员工姓名和工资
select ename,sal from emp where sal = (select max(sal) from emp);

-- 求工资高于所在部门平均工资的员工
select e1.ename,e1.sal,e2.asal from emp e1 
left join (select deptno, avg(sal) asal from emp group by deptno) e2
on e2.deptno = e1.deptno
where e1.sal > e2.asal;

-- 求平均工资最高的部门的部门编号和部门名称
select deptno,dname from dept 
	where deptno =  (
		select deptno from 
			(select avg(sal) avg_sal,deptno from emp group by deptno) d1
				inner join (select max(avg(sal)) avg_sal from emp group by deptno) d2
				on d1.avg_sal = d2.avg_sal
	);

-- 列出各部门工资最高的员工信息
select e1.ename,e1.deptno,e1.sal from emp e1
inner join 
(select max(sal) msal from emp group by deptno)
on sal = msal;

-- 求平均工资的级别最低的部门名称。
select d.dname,d.deptno from dept d inner join 
(select * from salgrade
inner join (select avg(sal) avg_sal, deptno from emp group by deptno)
on (avg_sal between losal and hisal) where grade = 
(select min(grade) from 
(select * from salgrade
inner join (select avg(sal) avg_sal, deptno from emp group by deptno)
on (avg_sal between losal and hisal)) d2)) d3
on d3.deptno = d.deptno;


-- 求比普通员工最高工资高的经理员工姓名
select ename from emp where sal > (select max(sal) from emp where empno not in (select distinct mgr from emp where mgr is not null));

-- 求工资最高的前5名员工姓名
select * from (select ename,sal from emp where sal is not null order by sal desc) where rownum <= 5;
-- 求工资最高的前6-10名员工姓名
select * from (select rownum rn, e.* from (select ename,sal from emp where sal is not null order by sal desc) e) where rn between 6 and 10;

-- 列出各部门平均工资及对应的工资等级
select grade, avg_sal from salgrade inner join
(select avg(sal) avg_sal, deptno from emp group by deptno)
on avg_sal between losal and hisal;

-- 列出各部门工资平均等级
select deptno, avg(grade) from emp, salgrade where sal between losal and hisal group by deptno;

-- 列出经理员工（拥有下级员工的员工）
select distinct b.ename from emp a,emp b where a.mgr = b.empno;

-- 求经理员工中平均工资的最低的部门名称
select dname from dept where deptno = (
	select e1.deptno from (select distinct avg(b.sal) avg_sal, b.deptno from emp a,emp b where a.mgr = b.empno group by b.deptno) e1
	inner join(
		select min(avg_sal) m_sal from
		(select distinct avg(b.sal) avg_sal, b.deptno from emp a,emp b where a.mgr = b.empno group by b.deptno) e2
	) on m_sal = avg_sal
);


