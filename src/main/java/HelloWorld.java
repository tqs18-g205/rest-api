/**
 *
 * @author tkardozo
 */
import java.util.logging.Logger;

public class HelloWorld {

   private static final Logger LOGGER = Logger.getLogger(
      Thread.currentThread().getStackTrace()[0].getClassName() );
    
  public static void main(String[] args) {
    //AHAHAHAH
    LOGGER.info("GoNutri FTW");
  }
    
}
