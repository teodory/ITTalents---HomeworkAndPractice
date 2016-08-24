package Library.readModels;

/**
 * Created by Parapanov on 23/08/2016.
 */
public abstract class Read {
    private String name;
    private String publishing;

    public Read(String name, String publishing) {
        this.name = name;
        this.publishing = publishing;
    }

    public String getName() {
        return name;
    }
}
