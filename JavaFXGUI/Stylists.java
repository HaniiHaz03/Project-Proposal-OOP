
/* DANIA ADRIANA BINTI MOHD FAIZAL*/
/* 22006373 */
/* PROGRAM : COMPUTER SCIENCE */
import java.util.ArrayList;
import java.util.List;

public class Stylists {
    private List<Stylist> stylists;

    public Stylists() {
        this.stylists = new ArrayList<>();
    }

    public void addStylist(Stylist stylist) {
        stylists.add(stylist);
    }

    public boolean removeStylist(String name) {
        return stylists.removeIf(stylist -> stylist.getName().equalsIgnoreCase(name));
    }

    public Stylist findStylist(String name) {
        return stylists.stream()
                .filter(stylist -> stylist.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<Stylist> getAllStylists() {
        return stylists;
    }

    public int getCount() {
        return stylists.size();
    }
}

