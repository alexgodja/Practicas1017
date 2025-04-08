package es.uji.alexandru.data;

import es.uji.alexandru.data.table.Table;

abstract class ReaderTemplate < T extends Table> {

    protected String source;
    protected T table;

    public ReaderTemplate(){
        this.source
    }

    abstract void openSource (String source);
    abstract void processHeaders (String headers);
    abstract void processData (String data);
    abstract void closeSource ();
    abstract boolean hasMoreData ();
    abstract String getNextData ();

    public final T readTableFromSource(){
        openSource(source);


        return table;
    }
}
