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

    public void removeStylist(String name) {
        stylists.removeIf(stylist -> stylist.getName().equals(name));
    }

    public Stylist findStylist(String name) {
        for (Stylist stylist : stylists) {
            if (stylist.getName().equals(name)) {
                return stylist;
            }
        }
        return null;
    }

    public List<Stylist> getAllStylists() {
        return new ArrayList<>(stylists);
    }
}



