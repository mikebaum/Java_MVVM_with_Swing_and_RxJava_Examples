/**
 * Copyright 2015 Peti Koch
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.petikoch.examples.mvvm_rxjava.example3;

import ch.petikoch.examples.mvvm_rxjava.rxjava_mvvm.IView;
import ch.petikoch.examples.mvvm_rxjava.rxjava_mvvm.RxSwingView2ViewModelBinder;
import ch.petikoch.examples.mvvm_rxjava.rxjava_mvvm.RxViewModel2SwingViewBinder;
import ch.petikoch.examples.mvvm_rxjava.widgets.StrictThreadingJButton;
import ch.petikoch.examples.mvvm_rxjava.widgets.StrictThreadingJFrame;
import ch.petikoch.examples.mvvm_rxjava.widgets.StrictThreadingJLabel;
import ch.petikoch.examples.mvvm_rxjava.widgets.StrictThreadingJTextField;

import java.awt.*;
import java.lang.management.ManagementFactory;

import static ch.petikoch.examples.mvvm_rxjava.rxjava_mvvm.RxSwingView2ViewModelBinder.bindSwingView;

class Example_3_View extends StrictThreadingJFrame implements IView<Example_3_ViewModel> {

    private final StrictThreadingJTextField nameTextField;
    private final StrictThreadingJTextField firstnameTextField;
    private final StrictThreadingJButton submitButton;

    public void bind(final Example_3_ViewModel viewModel) {
        bindSwingView(nameTextField).toViewModel(viewModel.v2vm_name);
        bindSwingView(firstnameTextField).toViewModel(viewModel.v2vm_firstname);
        RxSwingView2ViewModelBinder.bindSwingView(submitButton).toViewModel(viewModel.v2vm_submitButtonEvents);

        // additional to Example before:
        RxViewModel2SwingViewBinder.bindViewModelBoolean(viewModel.vm2v_submitButtonEnabled).toSwingViewEnabledPropertyOf(submitButton);
    }

    public Example_3_View() {
        super();
        setTitle(getClass().getSimpleName() + " " + ManagementFactory.getRuntimeMXBean().getName());

        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(StrictThreadingJFrame.EXIT_ON_CLOSE);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);

        StrictThreadingJLabel nameLabel = new StrictThreadingJLabel("Name");
        GridBagConstraints gbc_nameLabel = new GridBagConstraints();
        gbc_nameLabel.insets = new Insets(5, 5, 5, 5);
        gbc_nameLabel.anchor = GridBagConstraints.WEST;
        gbc_nameLabel.gridx = 0;
        gbc_nameLabel.gridy = 0;
        getContentPane().add(nameLabel, gbc_nameLabel);

        nameTextField = new StrictThreadingJTextField();
        GridBagConstraints gbc_nameTextField = new GridBagConstraints();
        gbc_nameTextField.gridwidth = 2;
        gbc_nameTextField.insets = new Insets(5, 0, 5, 5);
        gbc_nameTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nameTextField.gridx = 1;
        gbc_nameTextField.gridy = 0;
        getContentPane().add(nameTextField, gbc_nameTextField);
        nameTextField.setColumns(10);

        StrictThreadingJLabel firstNameLabel = new StrictThreadingJLabel("Firstname");
        GridBagConstraints gbc_firstNameLabel = new GridBagConstraints();
        gbc_firstNameLabel.anchor = GridBagConstraints.WEST;
        gbc_firstNameLabel.insets = new Insets(0, 5, 5, 5);
        gbc_firstNameLabel.gridx = 0;
        gbc_firstNameLabel.gridy = 1;
        getContentPane().add(firstNameLabel, gbc_firstNameLabel);

        firstnameTextField = new StrictThreadingJTextField();
        GridBagConstraints gbc_firstNameTextField = new GridBagConstraints();
        gbc_firstNameTextField.gridwidth = 2;
        gbc_firstNameTextField.insets = new Insets(0, 0, 5, 5);
        gbc_firstNameTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_firstNameTextField.gridx = 1;
        gbc_firstNameTextField.gridy = 1;
        getContentPane().add(firstnameTextField, gbc_firstNameTextField);
        firstnameTextField.setColumns(10);

        submitButton = new StrictThreadingJButton("Submit");
        GridBagConstraints gbc_submitButton = new GridBagConstraints();
        gbc_submitButton.insets = new Insets(0, 0, 0, 5);
        gbc_submitButton.anchor = GridBagConstraints.EAST;
        gbc_submitButton.gridx = 2;
        gbc_submitButton.gridy = 2;
        getContentPane().add(submitButton, gbc_submitButton);
    }
}
