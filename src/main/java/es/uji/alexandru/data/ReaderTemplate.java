package es.uji.alexandru.data;

import es.uji.alexandru.data.table.Table;

import java.net.URISyntaxException;

abstract class ReaderTemplate < T extends Table> {

    protected String source;
    protected String headers;
    protected String data;
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

    public final T readTableFromSource(){
        openSource(source);
        processHeaders(headers);
        processData(data);
        closeSource();
        hasMoreData();
        getNextData();

        return table;
    }
}
