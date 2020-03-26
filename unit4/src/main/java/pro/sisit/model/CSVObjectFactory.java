package pro.sisit.model;

public class CSVObjectFactory {
    public CSVObject createCSVObject(CSVObjectType type) {
        CSVObject csvObject = null;

        switch (type) {
            case AUTHOR:
                csvObject = new Author();
                break;
            case BOOK:
                csvObject = new Book();
                break;
            case LIBRARY:
                csvObject = new Library();
                break;
        }

        return csvObject;
    }
}
