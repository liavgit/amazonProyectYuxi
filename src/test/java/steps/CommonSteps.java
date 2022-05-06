package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import pages.BasePage;

//pasos comunes que se ejecutan
public class CommonSteps {

    //anotaciones de cucumber  y solo se considerna 1 vez para toda la ejecucion a  nivel global
    //se hace asi para que cada escenario sea independiente y se ejecute independientemente. 
    @Before
    public static void startNavigation(Scenario scenario) {//permite separar los escenarios. esto ejecuta cada escenario del feature. 
        BasePage.openBrowser();//del base page...es el que inicia el driver sea chrome  o ffox
    }

    //cierra el browser cuando finaliza el escenario 
    @After
    public static void closeNavigation(Scenario scenario) {
        if (scenario.isFailed()) {
            BasePage.takeScreenshot(scenario);//los screenshots se ven la carpeta que se crea como "pararela" al proyecto
        }
        //BasePage.closeBrower();
    }
    
}