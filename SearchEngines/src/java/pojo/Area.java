package pojo;

/**
 * Created by CHENCO7 on 8/1/2017.
 */
public class Area {
    private Integer id;
    private String areaId;
    private String area;
    private String cityId;

    public Area() {
    }

    public Area(Integer id, String areaId, String area, String cityId) {
        this.id = id;
        this.areaId = areaId;
        this.area = area;
        this.cityId = cityId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
}
