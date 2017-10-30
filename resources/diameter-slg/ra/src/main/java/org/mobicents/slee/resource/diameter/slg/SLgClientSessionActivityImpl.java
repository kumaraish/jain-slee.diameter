/*
 *
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2017, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 */

package org.mobicents.slee.resource.diameter.slg;

import java.io.IOException;

import net.java.slee.resource.diameter.base.DiameterException;
import net.java.slee.resource.diameter.base.events.ReAuthAnswer;
import net.java.slee.resource.diameter.base.events.avp.AvpNotAllowedException;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;
import net.java.slee.resource.diameter.slg.events.avp.*;
import net.java.slee.resource.diameter.slg.SLgAVPFactory;
import net.java.slee.resource.diameter.slg.SLgClientSessionActivity;
import net.java.slee.resource.diameter.slg.SLgMessageFactory;
import net.java.slee.resource.diameter.slg.SLgSessionActivity;
import net.java.slee.resource.diameter.slg.events.ProvideLocationRequest;
import net.java.slee.resource.diameter.slg.events.LocationReportRequest;

import org.jdiameter.api.Answer;
import org.jdiameter.api.EventListener;
import org.jdiameter.api.Request;
import org.jdiameter.api.Stack;
import org.jdiameter.api.app.AppSession;
import org.jdiameter.api.app.StateChangeListener;
import org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl;
// import org.jdiameter.api.slg.ClientSLgSession;
// import org.jdiameter.common.api.app.slg.ClientSLgSessionState;
// import org.jdiameter.common.impl.app.slg.LCSRoutingInfoRequestImpl;

/**
 * Implementation of {@link SLgClientSessionActivity}.
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public class SLgClientSessionActivityImpl{
  // to replace for underlying code
}

//public class SLgClientSessionActivityImpl extends SLgSessionActivityImpl implements SLgClientSessionActivity {
//
//  private static final long serialVersionUID = 7518916596996009148L;
//  protected transient ClientSLgSession appSession;
//
//  public SLgClientSessionActivityImpl(SLgMessageFactory slgMessageFactory, SLgAVPFactory slgAvpFactory, ClientSLgSession session, EventListener<Request, Answer> raEventListener, DiameterIdentity destinationHost, DiameterIdentity destinationRealm, Stack stack) {
//    super(slgMessageFactory, slgAvpFactory, session.getSessions().get(0), raEventListener, destinationHost, destinationRealm);
//    // FIXME: remove stack?
//
//    setSession(session);
//    super.setCurrentWorkingSession(session.getSessions().get(0));
//  }
//
//  public void setSession(ClientSLgSession session) {
//    this.appSession = session;
//    this.appSession.addStateChangeNotification(this);
//  }
//
//  public void stateChanged(Enum oldState, Enum newState) {
//    if (!terminated) {
//      if (newState == SLgSessionState.TERMINATED || newState == SLgSessionState.TIMEDOUT) {
//        terminated = true;
//        endActivity();
//      }
//    }
//  }
//
//  /*
//   * (non-Javadoc)
//   * @see org.jdiameter.api.app.StateChangeListener#stateChanged(java.lang.Object, java.lang.Enum, java.lang.Enum)
//   */
//  public void stateChanged(AppSession appSession, Enum oldState, Enum newState) {
//    this.stateChanged(oldState, newState);
//
//  }
//
//  @Override
//  public void endActivity() {
//    if (this.appSession != null) {
//      this.appSession.release();
//    }
//
//    try {
//      // endpoint.endActivity(this.getActivityHandle());
//      super.baseListener.endActivity(this.getActivityHandle());
//    }
//    catch (Exception e) {
//      logger.error("Failed to end activity [" + this + "].", e);
//    }
//  }
//
//  public void sendProvideLocationRequest(ProvideLocationRequest plr) throws IOException {
//    DiameterMessageImpl msg = (DiameterMessageImpl) plr;
//    ProvideLocationRequestImpl answer = new ProvideLocationRequestImpl((Request) msg.getGenericData());
//    try {
//      appSession.sendProvideLocationRequest(answer);
//    }
//    catch (org.jdiameter.api.validation.AvpNotAllowedException anae) {
//      throw new AvpNotAllowedException(anae.getMessage(), anae.getAvpCode(), anae.getVendorId());
//    }
//    catch (Exception e) {
//      if (logger.isDebugEnabled()) {
//        logger.debug("Failed to send message.", e);
//      }
//      throw new IOException(e.getMessage());
//    }
//  }
//
//  public void sendLocationReportRequest(LocationReportRequest lrr) throws IOException {
//    DiameterMessageImpl msg = (DiameterMessageImpl) lrr;
//    LocationReportRequestImpl answer = new LocationReportRequestImpl((Request) msg.getGenericData());
//    try {
//      appSession.sendLocationReportRequest(answer);
//    }
//    catch (org.jdiameter.api.validation.AvpNotAllowedException anae) {
//      throw new AvpNotAllowedException(anae.getMessage(), anae.getAvpCode(), anae.getVendorId());
//    }
//    catch (Exception e) {
//      if (logger.isDebugEnabled()) {
//        logger.debug("Failed to send message.", e);
//      }
//      throw new IOException(e.getMessage());
//    }
//  }
//
//  public ProvideLocationAnswer createProvideLocationAnswer() {
//    // Make sure we have the correct type of Request
//    if (!(lastRequest instanceof ProvideLocationAnswer)) {
//      logger.warn("Invalid type of answer for this activity.");
//      return null;
//    }
//
//    try {
//      // Create the answer
//      ProvideLocationAnswer pla = (ProvideLocationAnswer) this.slgMessageFactory.createSLgMessage(lastRequest.getHeader(), new DiameterAvp[]{}, ProvideLocationAnswer.COMMAND_CODE, slgMessageFactory.getApplicationId());
//
//      // Fill session related AVPs, if present
//      fillSessionAVPs(pla);
//
//      return pla;
//    }
//    catch (InternalException e) {
//      logger.error("Failed to create Provide-Location-Answer.", e);
//    }
//
//    return null;
//  }
//
//  public void sendLocationReportAnswer(LocationReportAnswer lra) throws IOException {
//    DiameterMessageImpl msg = (DiameterMessageImpl) lra;
//    LocationReportAnswerImpl request = new LocationReportAnswerImpl((Answer) msg.getGenericData());
//    try {
//      appSession.sendLocationReportAnswer(request);
//    }
//    catch (org.jdiameter.api.validation.AvpNotAllowedException anae) {
//      throw new AvpNotAllowedException(anae.getMessage(), anae.getAvpCode(), anae.getVendorId());
//    }
//    catch (Exception e) {
//      if (logger.isDebugEnabled()) {
//        logger.debug("Failed to send message.", e);
//      }
//      throw new IOException(e.getMessage());
//    }
//  }
//
//  public LocationReportAnswer createLocationReportAnswer(); {
//    // Make sure we have the correct type of Request
//    if (!(lastRequest instanceof LocationReportRequest)) {
//      logger.warn("Invalid type of answer for this activity.");
//      return null;
//    }
//
//    try {
//      // Create the answer
//      LocationReportAnswer lra = (InsertSubscriberDataAnswer) this.slgMessageFactory.createSLgMessage(lastRequest.getHeader(), new DiameterAvp[]{}, LocationReportAnswer.COMMAND_CODE, slgMessageFactory.getApplicationId());
//
//      // Fill session related AVPs, if present
//      fillSessionAVPs(lra);
//
//      return lra;
//    }
//    catch (InternalException e) {
//      logger.error("Failed to create Location-Report-Answer.", e);
//    }
//
//    return null;
//  }
//
//  public void sendLocationReportRequest(LocationReportRequest lrr) throws IOException {
//    DiameterMessageImpl msg = (DiameterMessageImpl) lrr;
//    LocationReportRequestImpl answer = new LocationReportRequestImpl((Request) msg.getGenericData());
//    try {
//      appSession.sendLocationReportRequest(answer);
//    }
//    catch (org.jdiameter.api.validation.AvpNotAllowedException anae) {
//      throw new AvpNotAllowedException(anae.getMessage(), anae.getAvpCode(), anae.getVendorId());
//    }
//    catch (Exception e) {
//      if (logger.isDebugEnabled()) {
//        logger.debug("Failed to send message.", e);
//      }
//      throw new IOException(e.getMessage());
//    }
//  }
//
//}
