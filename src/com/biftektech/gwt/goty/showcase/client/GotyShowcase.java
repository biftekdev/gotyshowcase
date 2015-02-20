package com.biftektech.gwt.goty.showcase.client;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.CheckBox;
import org.gwtbootstrap3.client.ui.Column;
import org.gwtbootstrap3.client.ui.Container;
import org.gwtbootstrap3.client.ui.Heading;
import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.ListBox;
import org.gwtbootstrap3.client.ui.Row;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.constants.ColumnSize;
import org.gwtbootstrap3.client.ui.constants.HeadingSize;
import org.gwtbootstrap3.client.ui.constants.InputType;

import com.biftektech.gwt.goty.shared.Goty;
import com.biftektech.gwt.goty.shared.GotyProperties;
import com.biftektech.gwt.goty.shared.enm.AnimateCss;
import com.biftektech.gwt.goty.shared.enm.CloseWith;
import com.biftektech.gwt.goty.shared.enm.Easing;
import com.biftektech.gwt.goty.shared.enm.NotificationLayout;
import com.biftektech.gwt.goty.shared.enm.NotificationTheme;
import com.biftektech.gwt.goty.shared.enm.NotificationType;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GotyShowcase implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		Container container = new Container();
		container.setFluid(true);
		
		ColumnSize labelSize = ColumnSize.MD_3;
		ColumnSize inputSize = ColumnSize.MD_9;
		
		Row rowText = new Row();
		container.add(rowText);
		rowText.add(new Column(labelSize, new Label("Text:")));
		final TextBox tbxText = new TextBox();
		tbxText.setText("Hello GWT!");
		tbxText.setMaxLength(255);
		rowText.add(new Column(inputSize, tbxText));
		
		
		Row rowTypes = new Row();
		container.add(rowTypes);
		rowTypes.add(new Column(labelSize, new Label("Type:")));
		final ListBox lboxTypes = new ListBox(false);
		for(NotificationType notificationType :NotificationType.values()) {
			lboxTypes.addItem(notificationType+"");
		}
		rowTypes.add(new Column(inputSize, lboxTypes));

		Row rowLayout = new Row();
		container.add(rowLayout);
		rowLayout.add(new Column(labelSize, new Label("Layout:")));
		final ListBox lboxLayouts = new ListBox(false);
		for(NotificationLayout notificationLayout :NotificationLayout.values()) {
			lboxLayouts.addItem(notificationLayout+"");
		}
		rowLayout.add(new Column(inputSize, lboxLayouts));
		
		Row rowTheme = new Row();
		container.add(rowTheme);
		rowTheme.add(new Column(labelSize, new Label("Theme:")));
		final ListBox lboxThemes = new ListBox(false);
		for(NotificationTheme notificationTheme :NotificationTheme.values()) {
			lboxThemes.addItem(notificationTheme+"");
		}
		rowTheme.add(new Column(inputSize, lboxThemes));
		
		Row rowDismissQue = new Row();
		container.add(rowDismissQue);
		final CheckBox cbxDismissQue = new CheckBox("Dismiss Que");
		final CheckBox cbxForce = new CheckBox("Force");
		final CheckBox cbxModal = new CheckBox("Modal");
		final CheckBox cbxKiller = new CheckBox("Killer");
		cbxDismissQue.setValue(true);
		rowDismissQue.add(new Column(labelSize,cbxDismissQue));
		rowDismissQue.add(new Column(inputSize, cbxForce, cbxModal, cbxKiller));
		
		Row rowTimeout = new Row();
		container.add(rowTimeout);
		final Input tbxTimeout = new Input(InputType.NUMBER);
		final CheckBox cbxTimeout = new CheckBox("Timeout");
		cbxTimeout.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				if(cbxTimeout.getValue()) {
					tbxTimeout.setVisible(true);
					tbxTimeout.setText("100");
				} else {
					tbxTimeout.setVisible(false);
					tbxTimeout.setText("-1");
				}
			}
		});
		cbxTimeout.setValue(false, true);
		rowTimeout.add(new Column(labelSize, cbxTimeout));
		rowTimeout.add(new Column(inputSize, tbxTimeout));
		
		Row rowMaxVisible = new Row();
		container.add(rowMaxVisible);
		rowMaxVisible.add(new Column(labelSize, new Label("Max Visible:")));
		final Input tbxMaxVisible = new Input();
		tbxMaxVisible.setType(InputType.NUMBER);
		tbxMaxVisible.setText("5");
		rowMaxVisible.add(new Column(inputSize, tbxMaxVisible));
		

		
		Row rowCloseWith = new Row();
		container.add(rowCloseWith);
		rowCloseWith.add(new Column(labelSize, new Label("Close With:")));
		final CheckBox cbxCloseWithClick = new CheckBox("Click");
		final CheckBox cbxCloseWithButton = new CheckBox("Button");
		final CheckBox cbxCloseWithHover = new CheckBox("Hover");
		final CheckBox cbxCloseWithBackdrop = new CheckBox("Backdrop");
		rowCloseWith.add(new Column(inputSize, cbxCloseWithClick, cbxCloseWithButton, cbxCloseWithHover, cbxCloseWithBackdrop));
		
		Row animationLabelRow = new Row();
		container.add(animationLabelRow);
		animationLabelRow.add(new Column(ColumnSize.MD_12, new Heading(HeadingSize.H2, "Animation")));
		
		Row rowOpenAnimation = new Row();
		container.add(rowOpenAnimation);
		rowOpenAnimation.add(new Column(labelSize, new Label("Open:")));
		final ListBox lboxOpenAnimation = new ListBox(false);
		for(AnimateCss animateCss :AnimateCss.values()) {
			lboxOpenAnimation.addItem(animateCss+"");
		}
		lboxOpenAnimation.setSelectedIndex(36);
		rowOpenAnimation.add(new Column(inputSize, lboxOpenAnimation));
		
		Row rowCloseAnimation = new Row();
		container.add(rowCloseAnimation);
		rowCloseAnimation.add(new Column(labelSize, new Label("Close:")));
		final ListBox lboxCloseAnimation = new ListBox(false);
		for(AnimateCss animateCss :AnimateCss.values()) {
			lboxCloseAnimation.addItem(animateCss+"");
		}
		lboxCloseAnimation.setSelectedIndex(38);
		rowCloseAnimation.add(new Column(inputSize, lboxCloseAnimation));
		
		Row rowEasing = new Row();
		container.add(rowEasing);
		rowEasing.add(new Column(labelSize, new Label("Easing:")));
		final ListBox lboxEasing = new ListBox(false);
		for(Easing easing :Easing.values()) {
			lboxEasing.addItem(easing+"");
		}
		rowEasing.add(new Column(inputSize, lboxEasing));
		
		Row rowAnimationSpeed = new Row();
		container.add(rowAnimationSpeed);
		rowAnimationSpeed.add(new Column(labelSize, new Label("Speed:")));
		final Input tbxSpeed = new Input();
		tbxSpeed.setType(InputType.NUMBER);
		tbxSpeed.setText("500");
		rowAnimationSpeed.add(new Column(inputSize, tbxSpeed));
		
		
		final Button btnCloseAll = new Button("Close All",new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Goty.closeAll();
			}
		});
		btnCloseAll.getElement().getStyle().setMarginLeft(5, Unit.PX);
		Button btnShow = new Button("Show", new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				GotyProperties gtp = GotyProperties.create();
				gtp.setText(tbxText.getText());
				gtp.setType(NotificationType.values()[lboxTypes.getSelectedIndex()]);
				gtp.setLayout(NotificationLayout.values()[lboxLayouts.getSelectedIndex()]);
				gtp.setTheme(NotificationTheme.values()[lboxThemes.getSelectedIndex()]);
				gtp.setDismissQueue(cbxDismissQue.getValue());
				gtp.setAnimateAnimation(
						AnimateCss.values()[lboxOpenAnimation.getSelectedIndex()],
						AnimateCss.values()[lboxCloseAnimation.getSelectedIndex()],
						Easing.values()[lboxEasing.getSelectedIndex()],
						Integer.valueOf(tbxSpeed.getText()));
				gtp.setMaxVisible(Integer.valueOf(tbxMaxVisible.getText()));
				gtp.setTimeout(Integer.valueOf(tbxTimeout.getText()));
				gtp.setForce(cbxForce.getValue());
				gtp.setModal(cbxModal.getValue());
				gtp.setKiller(cbxKiller.getValue());
				
				if(cbxCloseWithClick.getValue()) {
					gtp.addCloseWith(CloseWith.CLICK);
				} else {
					gtp.removeCloseWith(CloseWith.CLICK);
				}
				if(cbxCloseWithButton.getValue()) {
					gtp.addCloseWith(CloseWith.BUTTON);
				} else {
					gtp.removeCloseWith(CloseWith.BUTTON);
				}
				if(cbxCloseWithHover.getValue()) {
					gtp.addCloseWith(CloseWith.HOVER);
				} else {
					gtp.removeCloseWith(CloseWith.HOVER);
				}
				if(cbxCloseWithBackdrop.getValue()) {
					gtp.addCloseWith(CloseWith.BACKDROP);
				} else {
					gtp.removeCloseWith(CloseWith.BACKDROP);
				}
				Goty gty = Goty.show(gtp);
				
				
			}
		});
		
		
		Row rowLast = new Row();
		Column clm = new Column(ColumnSize.MD_12, btnShow,btnCloseAll);
		clm.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		rowLast.add(clm);
		container.add(rowLast);
		
		RootPanel.get("root").add(container);
	}
	
}
