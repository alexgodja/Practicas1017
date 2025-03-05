package es.uji.alexandru.machinelearning;

public interface Algorithm <T,I,L>{
    void train(T data);
    I estimate(L sample);
}
