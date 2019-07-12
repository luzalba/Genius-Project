package test;

public class GeniusTest extends BaseTest {

	public static void main(String[] args) {
		arrancarBrowser("http://genius.com");
		buscarCancion("Everlong");
		seleccionarCancion("Foo Fighters");
		cerrarNavegador();

	}

	

}
