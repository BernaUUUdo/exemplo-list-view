package br.com.bernard.tutoriais.list_view_example;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.bernard.tutoriais.list_view_example.model.Car;

public class ListExampleActivity extends AppCompatActivity {


    //1 . Método que retorna uma listagem de objetos
    //2 . Adicionar o listView ao leiaute XML
    //3.  Renomear no Leiaute
    //4.  Criar XML do adaptador
    //5.  Criar classe de adaptação: Responsável por associar o leiaute ao objeto.
    //6. Criar método de ação quando o item é clicado public void onItemClick(int mPosition) { Aqui
    //7. Setar a list em Oncreate ( Criar adaptador, listview, e amarrar com o médoto


    public ListExampleActivity mActivity;
    ListView listView;
    CarListItemAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_example);

        mActivity = this;
        Resources resources = getResources();

        //Cria a list View
        listView = (ListView) findViewById(R.id.listViewCars);
        //Cria o Adaptador
        adapter  = new CarListItemAdapter(mActivity,loadCarsExample(),resources);
        //Amarrando
        listView.setAdapter(adapter);

    }


    public void onItemClick(int mPosition) {
        Car car = (Car) adapter.getItem(mPosition);
        Log.v("activity", car.toString());


    }




    private static List<Car> loadCarsExample(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1,"Ford KA","SEL+","Sigma 1.5",2015 ));
        cars.add(new Car(2,"Fiat Punto","Atractive","1.4 Fire",2013 ));
        cars.add(new Car(3,"Fiat Punto","TJET","1.4 TurboJEt",2014 ));
        cars.add(new Car(4,"Citroen C4 Lounge","Ellegance","1.6 THP Prince",2015 ));
        return cars;

    }
}
