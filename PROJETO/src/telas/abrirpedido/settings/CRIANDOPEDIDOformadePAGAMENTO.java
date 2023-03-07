package telas.abrirpedido.settings;

import controleSQL.funcoes.AlterarValorTabela;
import controleSQL.funcoes.TABELA;
import telas.abrirpedido.ABRIRPEDIDO_settings;
import telas.abrirpedido.formasdepagamento.PAGAMENTOS;
import telas.buscapedidos.pedido;

public class CRIANDOPEDIDOformadePAGAMENTO extends ABRIRPEDIDO_settings{

//	******************************************************************************************************************************************************************************************************************************************
	
	public CRIANDOPEDIDOformadePAGAMENTO(PAGAMENTOS pagamento, pedido novo) {
		novo.setFormaDEpagamento(pagamento);
		new AlterarValorTabela().executar(TABELA.CLIENTE, "QUANTIDADE_PEDIDOS", novo.getCliente().getQuantidadePEDIDOS()+1,"ID" , novo.getCliente().getId());
		getModelo().setRowCount(0);
		getModelocarrinho().setRowCount(0);
		getTablecarrinho().removeAll();
		getTable().removeAll();
		ABRIRPEDIDO_settings.setNUMEROPEDIDO("");

	}
	
//	******************************************************************************************************************************************************************************************************************************************

}
