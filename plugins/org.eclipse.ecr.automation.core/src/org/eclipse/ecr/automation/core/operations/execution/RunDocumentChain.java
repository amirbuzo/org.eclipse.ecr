/*
 * Copyright (c) 2006-2011 Nuxeo SA (http://nuxeo.com/) and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     bstefanescu
 */
package org.eclipse.ecr.automation.core.operations.execution;

import org.eclipse.ecr.automation.AutomationService;
import org.eclipse.ecr.automation.OperationContext;
import org.eclipse.ecr.automation.core.Constants;
import org.eclipse.ecr.automation.core.annotations.Context;
import org.eclipse.ecr.automation.core.annotations.Operation;
import org.eclipse.ecr.automation.core.annotations.OperationMethod;
import org.eclipse.ecr.automation.core.annotations.Param;
import org.eclipse.ecr.automation.core.collectors.DocumentModelCollector;
import org.eclipse.ecr.core.api.DocumentModel;

/**
 * Run an embedded operation chain that returns a DocumentModel using the
 * current input.
 *
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 */
@Operation(id = RunDocumentChain.ID, category = Constants.CAT_SUBCHAIN_EXECUTION, label = "Run Document Chain", description = "Run an operation chain which is returning a document in the current context. The input for the chain ro run is the current input of the operation. Return the output of the chain as a document.")
public class RunDocumentChain {

    public static final String ID = "Context.RunDocumentOperation";

    @Context
    protected OperationContext ctx;

    @Context
    protected AutomationService service;

    @Param(name = "id")
    protected String chainId;

    @OperationMethod(collector=DocumentModelCollector.class)
    public DocumentModel run(DocumentModel doc) throws Exception {
        OperationContext subctx = new OperationContext(ctx.getCoreSession());
        subctx.setInput(doc);
        return (DocumentModel) service.run(subctx, chainId);
    }

}
