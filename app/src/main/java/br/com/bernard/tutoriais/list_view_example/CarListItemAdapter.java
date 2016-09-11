package br.com.bernard.tutoriais.list_view_example;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.bernard.tutoriais.list_view_example.model.Car;

/**
 * Created by bernard on 10/09/16.
 */


//1. getCount para informar a quantidade
//2. Construtor deve receber a atividade (activity) , os Objetos, e o Recusros?
//3. getView implementa a exibição do leiaute
//4. private class OnItemClickListener  implements View.OnClickListener{ serve para adicionar ação de clicar nos itens
//5  public static class ViewHolder{ casa o objeto ao leiout.
//6. Inflar a View
//7. Guardar na TAG para ser exibida nas demais posições


public class CarListItemAdapter  extends BaseAdapter implements View.OnClickListener {

    Activity activity;
    List<Car> cars;
    private static LayoutInflater inflater=null;
    public Resources res; // Está aqui para uso no caso de imagens

    public CarListItemAdapter(Activity activity, List<Car> cars, Resources res) {
        this.activity = activity;
        this.cars = cars;
        this.res = res;
        inflater     = ( LayoutInflater )activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        if( cars == null)
            return 0;
        else
            return cars.size();
    }

    @Override
    public Object getItem(int position) {
        if( position < cars.size()){
            return cars.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        if( position < cars.size()){
            return cars.get(position).getId();
        }
        return 0;
    }

    public static class ViewHolder{
        public TextView txtName;
        public TextView txtModel;
        public TextView txtEngine;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View templateView = convertView;
        ViewHolder holder;

        if( convertView == null ) {
            templateView = inflater.inflate(R.layout.list_item_car,null);

            holder = new ViewHolder();
            holder.txtName = (TextView) templateView.findViewById(R.id.txtName);
            holder.txtEngine = (TextView) templateView.findViewById(R.id.txtEngine);
            holder.txtModel = (TextView) templateView.findViewById(R.id.txtModel);

            templateView.setTag(holder);
        }else{
            holder =  (ViewHolder) templateView.getTag();
        }

        if(cars ==null || cars.size() == 0){
            holder.txtName.setText("Sem dados");
        }else{
            Car car = cars.get(position);
            holder.txtName.setText(car.getName());
            holder.txtModel.setText(car.getModel());
            holder.txtEngine.setText(car.getEngine());
            //Seta o método.
            templateView.setOnClickListener(new OnItemClickListener(position));
        }
        return templateView;
    }

    @Override
    public void onClick(View v) {
        Log.v("CustomAdapter", "=====Row button clicked=====");
    }


    private class OnItemClickListener  implements View.OnClickListener{
        private int mPosition;

        OnItemClickListener(int position){
            mPosition = position;
        }

        @Override
        public void onClick(View arg0) {
            ListExampleActivity listExampleActivity = (ListExampleActivity)activity;
            listExampleActivity.onItemClick(mPosition);
        }
    }

}
