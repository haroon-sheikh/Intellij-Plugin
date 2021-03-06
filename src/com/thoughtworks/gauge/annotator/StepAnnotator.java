// Copyright 2015 ThoughtWorks, Inc.

// This file is part of getgauge/Intellij-plugin.

// getgauge/Intellij-plugin is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.

// getgauge/Intellij-plugin is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

// You should have received a copy of the GNU General Public License
// along with getgauge/Intellij-plugin.  If not, see <http://www.gnu.org/licenses/>.

package com.thoughtworks.gauge.annotator;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.psi.PsiElement;
import com.thoughtworks.gauge.language.psi.ConceptStep;
import com.thoughtworks.gauge.language.psi.SpecStep;
import com.thoughtworks.gauge.language.psi.impl.SpecStepImpl;
import org.jetbrains.annotations.NotNull;

public class StepAnnotator implements com.intellij.lang.annotation.Annotator {

    private AnnotationHelper helper;

    public StepAnnotator(AnnotationHelper helper) {
        this.helper = helper;
    }

    public StepAnnotator() {
        this.helper = new AnnotationHelper();
    }

    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull AnnotationHolder holder) {
        if (!helper.isGaugeModule(element)) return;
        if (element instanceof SpecStep)
            createWarning(element, holder, (SpecStep) element);
        else if (element instanceof ConceptStep) {
            SpecStepImpl step = new SpecStepImpl(element.getNode());
            step.setConcept(true);
            createWarning(element, holder, step);
        }
    }

    private void createWarning(PsiElement element, AnnotationHolder holder, SpecStep step) {
        if (helper.isEmpty(step))
            holder.createErrorAnnotation(element.getTextRange(), "Step should not be blank");
        else if (!helper.isImplemented(step, helper.getModule(step)))
            holder.createErrorAnnotation(element.getTextRange(), "Undefined Step").registerFix(new CreateStepImplFix(step));
    }
}
