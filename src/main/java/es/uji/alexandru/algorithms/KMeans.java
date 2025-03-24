package es.uji.alexandru.algorithms;

import es.uji.alexandru.data.table.Row;
import es.uji.alexandru.data.table.Table;

import java.util.*;

public class KMeans implements Algorithm<Table,Integer,List<Double>> {
    private final int numClusters;
    private final int numIterations;
    private final long seed;
    private Map<Integer, Row> centroides=new HashMap();

    // Constructor. Almacena número de grupos, iteraciones y semilla.
    public KMeans(int numClusters, int numIterations, long seed) {
        this.numClusters = numClusters;
        this.numIterations = numIterations;
        this.seed = seed;
    }

    //Método train
    @Override
    public void train(Table data) {
        Random random=new Random(seed);
        List<Row> datosGrupo = new ArrayList();
        Map<Integer,List<Row>> grupos = new HashMap<>();

        for (int i=0;i<numClusters;i++){
            Row fila = data.getRowAt(random.nextInt());
            centroides.put(i,fila);
        }

        //
        for (int i=0;i<numIterations;i++){
            for(int j = 0; j < data.getRowCount(); j++)
            {
                Row fila = data.getRowAt(j);
                List<Double> listaDato = fila.getData();
                int numGrupo = estimate(listaDato);

                if(!grupos.containsKey(numGrupo))
                    grupos.put(numGrupo,new ArrayList<>());
                grupos.get(numGrupo).add(fila);
            }


        }

    }

    @Override
    public Integer estimate(List<Double> punto) {

        double distanciaMinima = Double.MAX_VALUE;
        int numGrupo = 0;

        for(int i =1;i<=numClusters;i++)
        {
            Row centroide = centroides.get(i);
            List<Double> datosCentroide = centroide.getData();
            double distanciaEuclidea = distanciaEuclidea(datosCentroide,punto);

            if(distanciaEuclidea<distanciaMinima)
                numGrupo = i;
        }

        return numGrupo;
    }

    public double distanciaEuclidea(List<Double> centroide, List<Double> punto)
    {
        double sum = 0;
        for(int i = 0; i < punto.size(); i++)
        {
            sum+=Math.pow(centroide.get(i) - punto.get(i),2);
        }
        return Math.sqrt(sum);
    }
}
