import net.tomp2p.futures.FutureDHT;
import net.tomp2p.p2p.Peer;
import net.tomp2p.peers.Number160;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by khaledsaied on 27/04/16.
 */
public class User {

    private Map<Number160,Group> groups;
    private Map<Number160,Admin> admins;
    private Map<Number160,Root> roots;

    public User() {
        groups = new HashMap<Number160, Group>();
        admins = new HashMap<Number160, Admin>();
        roots = new HashMap<Number160, Root>();
    }

    public void join(Peer myPeer, Number160 groupId, String password) {
        //Look root up and contact him...
        FutureDHT futureDHT = myPeer.get(groupId).start();
        futureDHT.awaitUninterruptibly();
        if (futureDHT.isSuccess()) {
             //futureDHT.getData().getObject().toString();
        }

        groups.put(groupId, new Group(groupId));
        roots.put(groupId, new Root("",0));
    }

    public void leave() {

    }

    public void createGroup(Number160 ownerId, String password) {
        Group group = new Group(ownerId);
        groups.put(ownerId, group);

        Admin admin = new Admin(ownerId, password);
        admins.put(ownerId, admin);

        //diffie-hellman

    }

    public void sendMsg(String msg, int groupId) {
        if(!admins.containsKey(groupId)) {

        }
        else {

        }

    }

    public void stabilization() {

    }

    public void forwardMsg() {

    }

    public void changeRole() {

    }

    public void handleLeave() {

    }

    public void handleKick() {

    }

}
