/*
 * Classe criada para gerenciar o grafico de barra JFreeChart.
*/
package projetodash2;

import java.awt.Dimension;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Maíra
 */
public class GraficoDeBarra 
{
    //1o passo: criando o dataset -- recebe uma lista de pessoas
    public CategoryDataset createDataset(ArrayList<Pessoa> listaPessoa) //esse método é próprio do JFree
    {
        //objeto responsável por deixar que se insiram dados no data set
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

        //acionando nome e pessoa ao gráfico
        for (Pessoa pessoa : listaPessoa) //pra cada pessoa
        {
            dataSet.addValue(pessoa.getAge(), pessoa.getName(), ""); //o ultimo parâmetro é columnKey. Não se aplica a esse gráfico 
        }
        
        return dataSet;
    }
    
    //2o passo: criar o gráfico de barras 
    //recebe o retorono do dataset
    public JFreeChart createBarChart(CategoryDataset dataSet)
    {
        JFreeChart graficoBarras = ChartFactory.createBarChart( "Pessoas e suas Idades", //titulo
                                                                "", //nome da linha
                                                                "Idade", //nome da coluna
                                                                dataSet /*dados*/,
                                                                PlotOrientation.HORIZONTAL, //direção do gráfico
                                                                true, /*se quer legendas */ 
                                                                false, /* se quer tooltip text*/
                                                                false /*se quer url no gráfico*/
                                                              );
        
        return graficoBarras;
    }
    
    //3o passo: criar o gráfico completo
    public ChartPanel criarGrafico(ArrayList<Pessoa> listaPessoas) //recebe a lista de pessoas e repassa pro dataset
    {
        CategoryDataset dataSet = this.createDataset(listaPessoas); //recebe o método createDataset que criei acima
        JFreeChart grafico = this.createBarChart(dataSet);
        ChartPanel painelDoGrafico = new ChartPanel(grafico); //passa o gráfico pro painel
        painelDoGrafico.setPreferredSize(new Dimension (400,400));
        
        return painelDoGrafico;
    }
}