import Item;

public class CuratedList {

    private List<Item> curatedItems;

    public CuratedList() {
        this.curatedItems = new List<Item>();
    }

    public List<Item> getCuratedItems() {
        return curatedItems;
    }

    public void setCuratedItems(List<Item> curatedItems) {
        this.curatedItems = curatedItems;
    }
}