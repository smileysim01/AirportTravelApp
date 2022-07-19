interface dataloaderinterface {
    public List<data> loadFile(String csvFilePath) throws FileNotFoundException;
    public List<data> loadAllFilesInDirectory(String directoryPath) throws FileNotFoundException;
}
public class dataload implements dataloaderInterface {
    /**
     *load data into the files
     *
     * @author yukun
     *
     */
    @Override
    public List<CarData> loadFile(String csvFilePath) throws FileNotFoundException {

    }
    /*
     * Class to load all files in a directory
     */
    @Override
    public List<data> loadAllFilesInDirectory(String directoryPath) throws FileNotFoundException {

    }
}