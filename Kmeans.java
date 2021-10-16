public class Kmeans {
    
    public static void main(String[] args) {        
        //inicializa dados com o exemplo do slide
        double[][] dados = inicializaDados(filename);
        
        //Numero de grupos
        int k = 3;

        int maxIteracoes = 500;

        //Definindo os centroides iniciais
        double[][] centroides = double[k][2];
        centroides[0][0] = dados[0][0];
        centroides[0][1] = dados[0][1];
        centroides[0][0] = dados[1][0];
        centroides[0][1] = dados[1][1];
        centroides[0][0] = dados[2][0];
        centroides[0][1] = dados[2][1];

        double[][] novosCentroides = kMeans(dados, centroides, maxIteracoes);
                
        exibirResultados(dados, novosCentroides);
        
    }
    
    public static double[][] inicializaDados() {
        double[][] dados = new double[10][2];
        dados[0][1] = 0;;
        dados[0][2] = 5;;
        dados[1][1] = 16;
        dados[1][2] = 18;
        dados[2][1] = 12;
        dados[2][2] = 27;
        dados[3][1] = 20;
        dados[3][2] = 30;
        dados[4][1] = 10;
        dados[4][2] = 7;
        dados[5][1] = 13;
        dados[5][2] = 1;
        dados[6][1] = 2;
        dados[6][2] = 18;
        dados[7][1] = 25;
        dados[7][2] = 9;
        dados[8][1] = 10;
        dados[8][2] = 3;
        dados[9][1] = 1;
        dados[9][2] = 2;
        return dados;        
    }

    public static double[][] kMeans(double[][] dados, double[][] centroides, int maxIteracoes) {        
        int numLinhas = dados.length;
        int numCols = dados[0].length;
        int k = centroides.length;
        double[][] novosCentroides = new double[k][numCols];
        int[] clustersAgrupamentos = new int[numLinhas];
        boolean estabilizou = false;
        int iter = 0;
        while (!estabilizou && iter < maxIteracoes) {
            for (int i = 0; i < numLinhas; i++) {
                double minDist = 9999999;
                int minIndex = -1;
                for (int j = 0; j < k; j++) {
                    double dist = 0;
                    for (int l = 0; l < numCols; l++) {
                        //A distancia é calculada pela soma dos quadrados das diferenças dos dois valores de cada elemento
                        dist += Math.pow(dados[i][l] - centroides[j][l], 2);
                    }
                    if (dist < minDist) {
                        minDist = dist;
                        minIndex = j;
                    }
                }
                clustersAgrupamentos[i] = minIndex;
            }
            // Atualiza centroides
            for (int i = 0; i < k; i++) {
                double[] newCentroid = new double[numCols];
                int numPoints = 0;
                for (int j = 0; j < numLinhas; j++) {
                    if (clustersAgrupamentos[j] == i) {
                        for (int l = 0; l < numCols; l++) {
                            newCentroid[l] += dados[j][l];
                        }
                        numPoints++;
                    }
                }
                for (int l = 0; l < numCols; l++) {
                    newCentroid[l] /= numPoints;
                }
                novosCentroides[i] = newCentroid;
            }
            // Verifica se os elementos pararam de mudar de cluster
            estabilizou = true;
            for(int i = 0; i < k; i++) {
                for(int j = 0; j < numCols; j++) {
                    if(centroides[i][j] != novosCentroides[i][j]) {
                        estabilizou = false;
                    }
                }
            }
            centroides = novosCentroides;
            iter++;
        }

        return centroides;

    }

    public static void exibirResultados(double[][] dados, double[][] centroides) {        
        int numLinhas = dados.length;
        int numCols = dados[0].length;
        int k = centroides.length;
        for (int i = 0; i < numLinhas; i++) {
            int cluster = -1;
            double minDist = 9999999;
            for (int j = 0; j < k; j++) {
                double dist = 0;
                for (int l = 0; l < numCols; l++) {
                    dist += Math.pow(dados[i][l] - centroides[j][l], 2);
                }
                if (dist < minDist) {
                    minDist = dist;
                    cluster = j;
                }
            }
            System.out.print("Cluster " + cluster + ": ");
            for (int j = 0; j < numCols; j++) {
                System.out.print(dados[i][j] + " ");
            }
            System.out.println();
        }   
    }
}