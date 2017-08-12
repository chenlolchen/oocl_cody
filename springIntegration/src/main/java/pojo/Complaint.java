package pojo;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by CHENCO7 on 8/11/2017.
 */
@Embeddable
public class Complaint {
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
}
