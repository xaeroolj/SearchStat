package dbService.dataSets;



import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by User on 22.12.2017.
 */
@Entity
@Table(name="pages")
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="url", length = 400)
    private String url;

    @Column(name="type_page", length = 10)
    private String type_page;

    @Column(name="long_url", length = 2048)
    private String long_url;

    @ManyToOne
    @JoinColumn(name = "site_id")
    private Site site;


    @Column (name = "found_date_time")
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date foundDateTime;

    @Column (name = "last_scan_date")
    @Temporal(value=TemporalType.DATE)
    private Date lastScanDate;

    public Page() {
    }

    public String getType_page() {
        return type_page;
    }

    public void setType_page(String type_page) {
        this.type_page = type_page;
    }

    public String getLong_url() {
        return long_url;
    }

    public void setLong_url(String long_url) {
        this.long_url = long_url;
    }

    public Page(String url, Site site, Date foundDateTime, Date lastScanDate, String type_page, String long_url) {
        this.url = url;
        this.site = site;
        this.foundDateTime = foundDateTime;
        this.lastScanDate = lastScanDate;
        this.type_page = type_page;
        this.long_url = long_url;
    }

    public Page(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Date getFoundDateTime() {
        return foundDateTime;
    }

    public void setFoundDateTime(Date foundDateTime) {
        this.foundDateTime = foundDateTime;
    }

    public Date getLastScanDate() {
        return lastScanDate;
    }

    public void setLastScanDate(Date lastScanDate) {
        this.lastScanDate = lastScanDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");

        return "Page {" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", site='" + site.getName() + '\'' +
                ", FoundDateTime='" + sdfDateTime.format(foundDateTime) + '\'' +
                "}";
    }
}
