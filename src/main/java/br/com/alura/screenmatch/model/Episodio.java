package br.com.alura.screenmatch.model;

import lombok.Data;
import lombok.ToString;

import java.time.DateTimeException;
import java.time.LocalDate;

@Data
public class Episodio {
    private Integer temporada;
    private String titulo;
    private Integer  numeroEpidosdio;
    private Double avaliacao;
    private LocalDate dataLancamento;

    public Episodio(Integer numeroTemporada, DadosEpisodio dadosEpisodio){
        this.temporada = numeroTemporada;
        this.titulo = dadosEpisodio.titulo();
        this.numeroEpidosdio = dadosEpisodio.numero();
        try {
            this.avaliacao = Double.valueOf(dadosEpisodio.avaliacao());
        } catch(NumberFormatException ex){
            this.avaliacao = 0.0;
        }
        try {
            this.dataLancamento = LocalDate.parse(dadosEpisodio.dataLancamento());
        }catch (DateTimeException ex){
            this.dataLancamento = null;
        }
    }

    @Override
    public String toString() {
        return "{" +
                "temporada=" + temporada +
                ", titulo='" + titulo + '\'' +
                ", numeroEpidosdio=" + numeroEpidosdio +
                ", avaliacao=" + avaliacao +
                ", dataLancamento=" + dataLancamento +
                '}';
    }
}
