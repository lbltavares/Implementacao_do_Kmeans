

## Implementação do Kmeans em Java

Trabalho da disciplina Planejamento De Capacidade E Avaliação De Sistemas Computacionais

**Professor**: Claudio Correa

**Alunos**: 
- Cristiano Coelho
- Lucas Laborne
- Gabriel Haddad
- Caique Ribeiro


K-Means é um algoritmo de agrupamento que utiliza aprendizado não-supervisionado para avaliar e clusterizar dados de acordo com as suas características. 

### **Algoritmo K-Means**

- O algoritmo k-means produz kclusters.
- Cada cluster é representado por seu centróide;
  - elemento cujas coordenadas são obtidas computando-se:
    - para cada coordenada do centróide, a média das correspondentes coordenadas de todos os elementos do cluster.
- Selecione o número de clusters desejados: k.
- Escolha k elementos iniciais;
  - para serem utilizados como as estimativas iniciais dos centróides dos kclusters.
- Enquanto algum elemento trocar de cluster ou o número máximo de iterações não for atingido:
  - calcule a distância entre cada elemento da carga de trabalho e o centróide de cada cluster;
  - inclua o elemento no cluster cujo centróide estiver mais próximo;
  - recalcule o centróide de cada cluster modificado nessa iteração.

![image](https://user-images.githubusercontent.com/34322384/137566551-18cec418-a1d6-4eec-a150-24ebadde40a2.png)
