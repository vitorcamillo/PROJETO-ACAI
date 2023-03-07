package telas.buscapedidos;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controleSQL.funcoes.BuscaTodosDaTabela;
import telas.clientes.cliente;
import telas.item.item;

public class BUSCAPEDIDO_settings {

	private static String NUMEROPEDIDO;
	private static cliente CLIENTEachado;
	private static JLabel lblTOTAL = new JLabel();
	private static int conta = 0;
	private static double totalCARRINHO ;
	private static JTable tableBUSCApedido;
	
//	******************************************************************************************************************************************************************************************************************************************

	private static DefaultTableModel modelobuscapedido = new DefaultTableModel(new Object[][] {},
			new String[] { "NOME", "PRECO", "QUANTIDADE", "ID" }) {
				private static final long serialVersionUID = -6664891039793316203L;
		boolean[] columnEditables = new boolean[] { false, false, false };

		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
	};
	
//	******************************************************************************************************************************************************************************************************************************************
	protected static pedido buscaPEDIDO(String id) {
			List<pedido> listapedido = new BuscaTodosDaTabela().getPedido();
			Map<String,pedido> map = new HashMap<>();
			for (pedido pedido : listapedido) {
				map.put(pedido.getID(), pedido);
				System.out.println("gravei pedido :" + pedido.getID());
			}
			Map<Integer,item> novo = map.get(id).getTabela();
			List<item> cria = new ArrayList<>(novo.values());
			for(item cada : cria) {
				criarBUSCApedido(cada);
			}
		
		return map.get(id);
	}
	
	
//	******************************************************************************************************************************************************************************************************************************************

	private static void criarBUSCApedido(item recebe) {
		Object[] gravador = criaOBJETOitem(recebe);
		procuraSEexisteCASOSIMeleADICIONA(gravador);
		procuraSEexisteALGUMcadastro(gravador);
		procuraPARAgravarNObuscaPEDIDO(gravador);
		conta = 0;

	}
//	******************************************************************************************************************************************************************************************************************************************

	private static void procuraSEexisteCASOSIMeleADICIONA(Object[] gravador) {
		for (int row = 0; row < modelobuscapedido.getRowCount(); row++) {
			if (modelobuscapedido.getValueAt(row, 0).equals(gravador[0])) {
				int val = (Integer) modelobuscapedido.getValueAt(row, 2);
				modelobuscapedido.setValueAt(val + 1, row, 2);
				break;
			}

		}

	}
//	******************************************************************************************************************************************************************************************************************************************

	private static void procuraSEexisteALGUMcadastro(Object[] gravador) {
		if (modelobuscapedido.getRowCount() == 0) {
			modelobuscapedido.addRow(gravador);
		}

	}
//	******************************************************************************************************************************************************************************************************************************************

	private static void procuraPARAgravarNObuscaPEDIDO(Object[] gravador) {

		for (int row = 0; row < modelobuscapedido.getRowCount(); row++) {
			if (modelobuscapedido.getValueAt(row, 0).equals(gravador[0])) {
				conta++;
				System.out.println("conta: " + conta);
			}

		}
		if (conta == 0) { // SE NAO HOUVER LINHA, ELE GRAVA
			modelobuscapedido.addRow(gravador);

		}

	}
//	*****************************************************************************************************************************************************************************************************************************************
	

	private static Object[] criaOBJETOitem(item recebe) {
		Object[] gravador = new Object[4];
		gravador[0] = recebe.getNome();
		gravador[1] = recebe.getValor();
		gravador[2] = recebe.getQuantidade();
		gravador[3] = recebe.getId();
		return gravador;

	}
//	******************************************************************************************************************************************************************************************************************************************

	public static JTable getTableBUSCApedido() {
		return tableBUSCApedido;
	}


	public static void setTableBUSCApedido(JTable tableBUSCApedido) {
		BUSCAPEDIDO_settings.tableBUSCApedido = tableBUSCApedido;
	}

	public static int getConta() {
		return conta;
	}

	public static void setConta(int conta) {
		BUSCAPEDIDO_settings.conta = conta;
	}


	public static double getTotalCARRINHO() {
		return totalCARRINHO;
	}

	public static void setTotalBUSCApedido(double totalBUSCApedido) {
		BUSCAPEDIDO_settings.totalCARRINHO = totalBUSCApedido;
	}

	public static JLabel getlblTOTAL() {
		return lblTOTAL;
	}

	public static void setlblTOTAL(JLabel lblTOTAL) {
		BUSCAPEDIDO_settings.lblTOTAL = lblTOTAL;
	}

	
	public static DefaultTableModel getModeloBUSCApedido() {
		return modelobuscapedido;
	}

	public static void setModelocarrinho(DefaultTableModel modelocarrinho) {
		BUSCAPEDIDO_settings.modelobuscapedido = modelocarrinho;
	}

	public static cliente getCLIENTEachado() {
		return CLIENTEachado;
	}

	public static void setCLIENTEachado(cliente cLIENTEachado) {
		CLIENTEachado = cLIENTEachado;
	}

	public static String getNUMEROPEDIDO() {
		return NUMEROPEDIDO;
	}

	public static void setNUMEROPEDIDO(String nUMEROPEDIDO) {
		NUMEROPEDIDO = nUMEROPEDIDO;
	}
	
	
	
	
}
