package com.example.ecodrive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class lista_combustivel extends AppCompatActivity {
    private EditText valorCombustivel;
    private EditText valorAbastecido;
    private EditText kmAtual;
    private CombustivelDAO dao = new CombustivelDAO(this);
    private Combustivel_Class combustivel_class1 = new Combustivel_Class();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_combustivel);

        Intent intent = getIntent();
        Combustivel_Class combustivel_class = (Combustivel_Class)intent.getSerializableExtra("Contato");
        if (combustivel_class != null){
            valorCombustivel.setText((int)combustivel_class.getValorCombustivel());
            valorAbastecido.setText((int) combustivel_class.getValorAbastecido());
            kmAtual.setText((int)combustivel_class.getKmAtual());
            this.combustivel_class1 = combustivel_class;
        }
    }

    private void btn_cadastrarAbastecida(){
        Button btn_cadastrarAbastecida = findViewById(R.id.btn_cadastrarAbastecida);
        btn_cadastrarAbastecida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (combustivel_class1.getId() != null){
                    Combustivel_Class abastecidaAtualizada = atualizaAbastecida();
                    dao.altera(abastecidaAtualizada);
                }else{
                    Combustivel_Class abastecidaCriada = criaContato();
                    dao.salvar(contatoCriado);
                }
                finish();
            }
        });
    }

    private Combustivel_Class criaAbastecida(){
        float valorCombustivel = valorCombustivel.getText().toString();
        float valorAbastecido = valorAbastecido.getText().toString();
        float kmAtual = kmAtual.getText().toString();

        return new Combustivel_Class(valorCombustivel, valorAbastecido, kmAtual);
    }

    private Combustivel_Class atualizaAbastecida(){
        Long id = combustivel_class1.getId();
        float valorCombustivel = valorCombustivel.getText().toString();
        float valorAbastecido = valorAbastecido.getText().toString();
        float kmAtual = kmAtual.getText().toString();

        return new Combustivel_Class(id, valorCombustivel, valorAbastecido, kmAtual);
    }
}
