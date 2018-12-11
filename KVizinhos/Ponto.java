/**
* Autor: Marcos Tadeu de Sousa Cunha
*/
public class Ponto {
    
    // variáveis do ponto
    private double x;
    private double y;
    private double distance;
    
    // construtor
    public Ponto(double a, double b){
        // o construtor recebe os valores lidos e os declara 
        x = a;
        y = b;
        distance = 0;
    }
    
    // metódo de impressão das coordenadas de um ponto
    public String toString(){
        return "X: " + this.x + "\nY: " + this.y + "\nDistância: " + distance;
    }
    
    // metódo que irá calcular a distância de um ponto de referência comparado a outro ponto
    public void distance(Ponto outro){
        // Math.sqrt(Math.pow(N - X, 2) + (Math.pow(M - Y, 2)))
        outro.distance = Math.sqrt(Math.pow(this.x - outro.x, 2) + (Math.pow(this.y - outro.y, 2)));
        //return distance;
    }
    
    // metódo que irá calcular a distância de um ponto de referência comparado a outro ponto
    public Boolean semaior(Ponto outro){
        if(this.distance > outro.distance){
            return true;
        }
        return false;
    }
    
    // metódo que irá calcular a distância de um ponto de referência comparado a outro ponto
    public Boolean semenor(Ponto outro){
        if(this.distance < outro.distance){
            return true;
        }
        return false;
    }
}
