package Person.Injector;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * @author Bondarev Denis
 */
public class Injector {

    private static final Logger log = Logger.getLogger(Injector.class);

    /**
     * @param obj - object to check for annotation
     */
    public void inject(Object obj) {
        log.info("set field with annotation @inject new value");
        Properties prop = new Properties();
        InputStream inp;
        try {
            inp = new FileInputStream("src/main/resources/config.properties");
            try {
                prop.load(inp);
                Class<?> value;
                try {
                    Class cl = obj.getClass();
                    Field[] field = cl.getDeclaredFields();
                    value = Class.forName(prop.getProperty("Sorters.Sorter"));
                    for (int i = 0; i < field.length; i++) {
                        Annotation[] an = field[i].getAnnotations();
                        for (int j = 0; j < an.length; j++) {
                            if (an[j].toString().equals("@Person.Injector.Inject()")) {
                                field[i].setAccessible(true);
                                try {
                                    field[i].set(obj, value.newInstance());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                } catch (ClassNotFoundException e) {
                    log.fatal("class by name not found");
                    e.printStackTrace();
                }
            } catch (IOException e) {
                log.fatal("can't load file");
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            log.fatal("config property not found");
            e.printStackTrace();
        }
    }
}


