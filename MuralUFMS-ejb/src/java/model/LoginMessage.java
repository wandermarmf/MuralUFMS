/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author wandermar
 */
@JMSDestinationDefinition(name = "java:app/jms/LoginMessage", interfaceName = "javax.jms.Queue", resourceAdapter = "jmsra", destinationName = "LoginMessage")
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:app/jms/LoginMessage"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class LoginMessage implements MessageListener {

    @Resource
    private MessageDrivenContext mdc;

    @PersistenceContext(unitName = "MuralUFMS-ejbPU")
    private EntityManager em;

    public LoginMessage() {
    }

    @Override
    public void onMessage(Message message) {
        ObjectMessage msg = null;
        try {
            if (message instanceof ObjectMessage) {
                msg = (ObjectMessage) message;
                Login l = (Login) msg.getObject();
                save(l);
            }
        } catch (JMSException e) {
            e.printStackTrace();
            mdc.setRollbackOnly();
        } catch (Throwable te) {
            te.printStackTrace();
        }
    }

    public void save(Object object) {
        em.persist(object);
    }

}
