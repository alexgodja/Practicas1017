package Modelo.data;

import Modelo.data.table.Table;

import java.net.URISyntaxException;

abstract class ReaderTemplate < T extends Table> {

    protected String source;
    protected T table;

    public ReaderTemplate(String source) {
        this.source = source;
    }

    abstract void openSource (String source) throws URISyntaxException;
    abstract void processHeaders (String headers);
    abstract void processData (String data);
    abstract void closeSource ();
    abstract boolean hasMoreData ();
    abstract String getNextData ();

    public final T readTableFromSource() throws URISyntaxException{
        openSource(source);
        if (hasMoreData()) {
            String headersLine=getNextData();
            processHeaders(headersLine);
        }
        while (hasMoreData()){
            String data=getNextData();
            processData(data);
        }
        closeSource();
        return table;
    }
}
