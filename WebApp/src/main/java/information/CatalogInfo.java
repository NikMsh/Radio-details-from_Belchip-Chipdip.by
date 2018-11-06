package information;

public class CatalogInfo {
    private String URL;
    private String name;

    public CatalogInfo(String URL, String name) {
        this.URL = URL;
        this.name = name;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "URL='" + URL + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

