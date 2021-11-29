package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import db.DbException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.entities.Departamento;
import model.services.DepartamentoService;

public class DepartamentoFormController implements Initializable {

	private Departamento entity;
	private DepartamentoService service;
	private List<DataChangeListener> dataChangeListeners = new ArrayList<>();

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtNome;

	@FXML
	private Label lbError;

	@FXML
	private Button btSave;

	@FXML
	private Button btCancel;

	public void setDepartamento(Departamento entity) {
		this.entity = entity;
	}

	public void setDepartamentoService(DepartamentoService service) {
		this.service = service;
	}

	public void subscribeDataChangeListers(DataChangeListener listener) {
		dataChangeListeners.add(listener);
	}

	@FXML
	public void onBtSaveAction(ActionEvent event) {
		if (entity == null) {
			throw new IllegalStateException("Entidade null");
		}
		if (service == null) {
			throw new IllegalStateException("Serviço null");
		}
		try {
			entity = getFormData();
			service.saveOrUpdate(entity);
			notifyDataChangeLiteners();
			Utils.currentStage(event).close();
		} catch (DbException e) {
			Alerts.showAlert("Erro em salvar o objeto", null, e.getMessage(), AlertType.ERROR);
		}
	}

	private void notifyDataChangeLiteners() {
		for (DataChangeListener listener : dataChangeListeners) {
			listener.onDataChanged();
		}
	}

	private Departamento getFormData() {
		Departamento obj = new Departamento();
		obj.setId(Utils.tryParserToInt(txtId.getText()));
		obj.setNome(txtNome.getText());

		return obj;
	}

	@FXML
	public void onBtCancelAction(ActionEvent event) {
		Utils.currentStage(event).close();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtNome, 30);
	}

	public void updateFormData() {
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		txtId.setText(String.valueOf(entity.getId()));
		txtNome.setText(entity.getNome());
	}

}
