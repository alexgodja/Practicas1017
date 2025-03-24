package es.uji.alexandru.algorithms;

import es.uji.alexandru.data.table.Row;
import es.uji.alexandru.data.table.Table;
import es.uji.alexandru.excepciones.InvalidClusterNumberException;

import java.util.*;

public class KMeans implements Algorithm<Table,Integer,List<Double>> {
    private final int numClusters;
    private final int numIterations;
    private final long seed;
    private Map<Integer, List<Double>> centroides=new HashMap();

    // Constructor. Almacena número de grupos, iteraciones y semilla.
    public KMeans(int numClusters, int numIterations, long seed) {
        this.numClusters = numClusters;
        this.numIterations = numIterations;
        this.seed = seed;
    }

    //Método train
    @Override
    public void train(Table data) {

        if (numClusters > data.getRowCount()) {
            throw new InvalidClusterNumberException(numClusters, data.getRowCount());
        }

        Random random=new Random(seed);
        List<Row> datosGrupo = new ArrayList();
        Map<Integer,List<Row>> grupos = new HashMap<>();

        for (int i=1;i<=numClusters;i++){
            List<Double> fila = data.getRowAt(random.nextInt()).getData();
            centroides.put(i,fila);
        }

        //
        for (int i=0; i < numIterations; i++){
            for(int j = 0; j < data.getRowCount(); j++)
            {
                Row fila = data.getRowAt(j);
                List<Double> listaDato = fila.getData();
                int numGrupo = estimate(listaDato);

                if(!grupos.containsKey(numGrupo))
                    grupos.put(numGrupo,new ArrayList<>());
                grupos.get(numGrupo).add(fila);
            }
            for(int j = 1; j <= numClusters; j++)
            {
                List<Double> centroideRecalculado = new ArrayList();
                int numPuntos = grupos.get(j).size();
                double sumX = 0;
                double sumY = 0;
                double sumZ = 0;
                double sumW = 0;

                for(int k = 0; k < numPuntos; k++)
                {

                    Row fila = grupos.get(j).get(k);
                    List<Double> datosFila = fila.getData();
                    sumX += datosFila.get(0);
                    sumY += datosFila.get(1);
                    sumZ += datosFila.get(2);
                    sumW += datosFila.get(3);
                }

                centroideRecalculado.add(sumX/numPuntos);
                centroideRecalculado.add(sumY/numPuntos);
                centroideRecalculado.add(sumZ/numPuntos);
                centroideRecalculado.add(sumW/numPuntos);

                centroides.put(j,centroideRecalculado);
            }
        }

    }

    @Override
    public Integer estimate(List<Double> punto) {

        double distanciaMinima = Double.MAX_VALUE;
        int numGrupo = 0;

        for(int i =1; i<= numClusters; i++)
        {
            List<Double> centroide = centroides.get(i);
            double distanciaEuclidea = distanciaEuclidea(centroide,punto);

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
