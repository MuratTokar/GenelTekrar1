package day_031_Scenario_Background_Variables_DataTables.openchart.datatables;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

public class DatatablevariableSteps {
    @Given("write the following numbers {int}, {int}, {int}, {int}, {int}")
    public void writeTheFollowingNumbers(int arg0, int arg1, int arg2, int arg3, int arg4) {
    }

    @Given("write the following numbers")
    public void writeTheFollowingNumbers(DataTable table) { // scenario da data table yazdik stepin altina ama burda göstermedi.
        // o halde DataTable table ekleriz ve asagiyi list aliriz eger   List<Integer> list burasi integer ise table.asList(Integer.class); buraya
       // Integer.clas  belirtmeliyiz ama List<String> list burasi String  ise table.asList()  aslist icine birsey yazmiyoruz
        List<Integer> list=table.asList(Integer.class);
        list.forEach(e-> System.out.println(e)); // degerleri yazdik
        System.out.println("********************************************");
    }

    @Given("write the following numbers String")
    public void writeTheFollowingNumbersString(DataTable table) {
        List<String> list=table.asList();
        list.forEach(e-> System.out.println(e));
        System.out.println("****************************************");
    }

    @Given("write the following numbers list of list")
    public void writeTheFollowingNumbersListOfList(DataTable table) {
        List<List<String>> lists=table.asLists();
        lists.forEach(list->{
            list.forEach(s -> System.out.print(s + "\t"));
            System.out.println();
        });
        System.out.println("***************************************");
    }

    @Given("write the following map")
    public void writeTheFollowingMap(DataTable table) {
        Map<String,String> map=table.asMap();
        System.out.println(map.get("username"));
        System.out.println(map.get("password"));
        System.out.println(map.get("firstname"));
        System.out.println(map.get("lastname"));
        System.out.println("****************************************");
        //ForEach ilede soyle yapilir
        map.forEach((k, v) -> System.out.println(k + ":" + v));
        System.out.println("******************************************");
    }

    @Given("write the following numbers as map")
    public void writeTheFollowingNumbersAsMap(DataTable table) {
        Map<Integer,Double> mapp=table.asMap(Integer.class, Double.class);
        mapp.forEach((k,v) -> System.out.println(k + ":" + v));
        System.out.println("********************************************");
    }

    @Given("write the following maps")
    public void writeTheFollowingMaps(DataTable table) {
        List<Map<String,String>> lists=table.asMaps();
        lists.forEach(map->{
            map.forEach((k,v)-> System.out.println(k +":" +v));
            System.out.println();
        });
    }
}
