public class PictureData {
    String fileName;
    String date;
    String description;

    /** PictureData has all getters, setters, and constructors for the data of the files
     * Has all variables that the files contain such as date, description, and the fileName
     * @param fileName
     * @param date
     * @param description
     */

    public PictureData(String fileName, String date, String description) {
        this.fileName = fileName;
        this.date = date;
        this.description = description;
    }

    public String getFilename() {
        return fileName;
    }

    public void setFilename(String fileName) {
        this.fileName = fileName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return fileName + "\t" + date + "\t" + description;
    }    

}
