/*
 Copyright (C) 2002-2004 MySQL AB

 This program is free software; you can redistribute it and/or modify
 it under the terms of version 2 of the GNU General Public License as
 published by the Free Software Foundation.
 

 There are special exceptions to the terms and conditions of the GPL 
 as it is applied to this software. View the full text of the 
 exception exception in file EXCEPTIONS-CONNECTOR-J in the directory of this 
 software distribution.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

 */
package com.mysql.jdbc;

import java.sql.SQLException;


/**
 * Thrown when a packet that is too big for the server is
 * created.
 *
 * @author Mark Matthews
 */
public class PacketTooBigException extends SQLException {
    /**
     * Creates a new PacketTooBigException object.
     *
     * @param packetSize DOCUMENT ME!
     * @param maximumPacketSize DOCUMENT ME!
     */
    public PacketTooBigException(long packetSize, long maximumPacketSize) {
        super("Packet for query is too large (" + packetSize + " > "
            + maximumPacketSize + "). "
            + "You can change this value on the server by setting the "
            + "max_allowed_packet' variable.", SQLError.SQL_STATE_GENERAL_ERROR);
    }
}
