package pro.sisit.model;

public class CSVObjectFactory {
    public CSVObject createCSVObject(String type) {
        CSVObject csvObject = null;

        switch (type) {
            case "Author":
                csvObject = new Author();
                break;
            case "Book":
                csvObject = new Book();
                break;
            case "Library":
                csvObject = new Library();
                break;
        }

        return csvObject;
    }
}
