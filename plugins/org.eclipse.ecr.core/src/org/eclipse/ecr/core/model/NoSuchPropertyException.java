/*
 * Copyright (c) 2006-2011 Nuxeo SA (http://nuxeo.com/) and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nuxeo - initial API and implementation
 *
 * $Id$
 */

package org.eclipse.ecr.core.model;

import org.eclipse.ecr.core.api.DocumentException;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 */
public class NoSuchPropertyException extends DocumentException {

    private static final long serialVersionUID = 4955736921750647945L;

    public NoSuchPropertyException() {
        super("The property doesn't exists");
    }

    public NoSuchPropertyException(String path) {
        super("The property at '" + path + "' doesn't exists");
    }

    public NoSuchPropertyException(String path, Throwable cause) {
        super("The property at '" + path + "' doesn't exists", cause);
    }

}
