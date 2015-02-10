// This is a generated file. Not intended for manual editing.
package com.thoughtworks.gauge.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class ConceptVisitor extends PsiElementVisitor {

  public void visitArg(@NotNull ConceptArg o) {
    visitPsiElement(o);
  }

  public void visitConcept(@NotNull ConceptConcept o) {
    visitPsiElement(o);
  }

  public void visitConceptHeading(@NotNull ConceptConceptHeading o) {
    visitPsiElement(o);
  }

  public void visitDynamicArg(@NotNull ConceptDynamicArg o) {
    visitPsiElement(o);
  }

  public void visitStaticArg(@NotNull ConceptStaticArg o) {
    visitPsiElement(o);
  }

  public void visitStep(@NotNull ConceptStep o) {
    visitNamedElement(o);
  }

  public void visitTable(@NotNull ConceptTable o) {
    visitPsiElement(o);
  }

  public void visitTableBody(@NotNull ConceptTableBody o) {
    visitPsiElement(o);
  }

  public void visitTableHeader(@NotNull ConceptTableHeader o) {
    visitPsiElement(o);
  }

  public void visitTableRowValue(@NotNull ConceptTableRowValue o) {
    visitPsiElement(o);
  }

  public void visitNamedElement(@NotNull ConceptNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
