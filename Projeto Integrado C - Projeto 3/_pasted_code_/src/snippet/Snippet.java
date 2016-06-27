package snippet;

public class Snippet {
	for (int i = 0; i < 5; i++) {
					
					for (int j = 0; j < 5; j++) {	
						
						if ((i == 2) && (j == 2)){
							System.out.println("Meio");
						}
						else{
							vl = vls.consulta(i, j, idCartela);
		        			System.out.println("" + vl.getValor());
						}
					}
					
				}
		
}

