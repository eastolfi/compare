package es.edu.java.compare;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import es.edu.java.utils.DeepEquals;
import es.edu.java.utils.GraphComparator;
import es.edu.java.utils.GraphComparator.Delta;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private GraphComparator.ID getFetcherID() {
        return new GraphComparator.ID() {
            @Override
            public Object getId(Object objectToId) {
                if (objectToId instanceof MiObjeto) {
                    MiObjeto obj = (MiObjeto)objectToId;
                    return "ID: " + obj.campo1 + "|" + obj.campo2;
                } else if (objectToId instanceof Collection || objectToId instanceof Map) {
                    return null;
                }

                throw new RuntimeException("Object does not support getId(): " + (objectToId != null ? objectToId.getClass().getName() : "null"));
            }
        };
    }

    // /**
    //  * Rigorous Test :-)
    //  */
    // @Test
    // @Ignore
    // public void shouldAnswerWithTrue()
    // {
    //     // MiObjeto pruebas = new MiObjeto("Holi");

    //     // MiObjeto pruebas2 = pruebas.clone();
    //     // pruebas2.campo1 = "Holi 2";
    //     // pruebas2.campo2 = ":D";

    //     // // MiObjeto distinto = new MiObjeto("Hola");
    //     // List<Delta> diff = GraphComparator.compare(pruebas, pruebas2, getFetcherID());

    //     List<MiObjeto> lista1 = new ArrayList<>();
    //     List<MiObjeto> lista2 = new ArrayList<>();
    //     lista2.add(new MiObjeto("Holi"));

    //     List<Delta> diff = GraphComparator.compare(lista1, lista2, getFetcherID());

    //     System.out.println(diff);

    //     List<MiObjeto> target = new ArrayList<>();
    //     System.out.println("Size of target: " + target.size());

    //     GraphComparator.applyDelta(target, diff, getFetcherID(), new CustomJavaDeltaProcessor());

    //     System.out.println("Size of target: " + target.size());

    //     // final MiObjeto target = new MiObjeto("Holi");
    //     // System.out.println(target);        

    //     // GraphComparator.applyDelta(target, diff, getFetcherID(), /*GraphComparator.getJavaDeltaProcessor()*/new CustomJavaDeltaProcessor());

    //     // System.out.println(target);


    //     // DiffNode diff2 = ObjectDifferBuilder.buildDefault().compare(pruebas, pruebas2);
        
    //     // diff2.visit(new DiffNode.Visitor(){
        
    //     //     @Override
    //     //     public void node(DiffNode node, Visit visit) {
    //     //         if (node.hasChanges() && !node.hasChildren()) {
    //     //             node.canonicalSet(target, node.canonicalGet(target));
    //     //         }
    //     //     }
    //     // });

    //     // ByteArrayOutputStream bos = new ByteArrayOutputStream();
    //     // ObjectOutput out = null;

    //     // try {
    //     //     out = new ObjectOutputStream(bos);
    //     //     out.writeObject(pruebas);
    //     //     out.flush();
    //     //     byte[] pruebasBytes = bos.toByteArray();

    //     //     bos = new ByteArrayOutputStream();
    //     //     out = new ObjectOutputStream(bos);
    //     //     out.writeObject(pruebas2);
    //     //     out.flush();
    //     //     byte[] pruebasBytes2 = bos.toByteArray();

    //     //     OutputStream os = null;

    //     //     Diff.diff(pruebasBytes, pruebasBytes2, os);

    //     //     // System.out.println(os);
    //     // } catch (Exception e) {
    //     //     System.out.println("Error 1");
    //     //     System.out.println(e);
    //     // } finally {
    //     //     try {
    //     //         bos.close();
    //     //     } catch (Exception e) {
    //     //         System.out.println("Error 2");
    //     //         System.out.println(e.getMessage());
    //     //     }
    //     // }


    //     assertTrue( true );
    // }

    public interface HasId {
        Object getId();
    }

    private GraphComparator.ID getIdFetcher() {
        return new GraphComparator.ID()
        {
            public Object getId(Object objectToId)
            {
                if (objectToId instanceof HasId)
                {
                    HasId obj = (HasId) objectToId;
                    return obj.getId();
                }
                else if (objectToId instanceof Collection || objectToId instanceof Map)
                {
                    return null;
                }
                throw new RuntimeException("Object does not support getId(): " + (objectToId != null ? objectToId.getClass().getName() : "null"));
            }
        };
    }

    private class PolicyHandle implements Cloneable {
        private String policyId;
        private String endorsementId;
        private String updateId;

        public PolicyHandle(String policyId, String endorsementId, String updateId) {
            this.policyId = policyId;
            this.endorsementId = endorsementId;
            this.updateId = updateId;
        }

        public void setPolicyId(String policyId) {
            this.policyId = policyId;
        }
        public String getPolicyId() {
            return policyId;
        }
        public void setEndorsementId(String endorsementId) {
            this.endorsementId = endorsementId;
        }
        public String getEndorsementId() {
            return endorsementId;
        }
        public void setUpdateId(String updateId) {
            this.updateId = updateId;
        }
        public String getUpdateId() {
            return updateId;
        }

        @Override
        public PolicyHandle clone() {
            try {
                return (PolicyHandle)super.clone();
            } catch (CloneNotSupportedException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }

        @Override
        public String toString() {
            return this.policyId + "|" + this.endorsementId + "|" + this.updateId;
        }
    }

    private class Policy implements HasId, Cloneable
    {
        private PolicyHandle policyHandle;
        private String address;
        private List<String> covers;

        public Policy(String policyId, String endorsementId, String updateId) {
            this.policyHandle = new PolicyHandle(policyId, endorsementId, updateId);
            this.address = "Address 1";
            this.covers = new ArrayList<>();
        }

        public void setPolicyHandle(PolicyHandle handle) {
            this.policyHandle = handle;
        }
        public PolicyHandle getPolicyHandle() {
            return this.policyHandle;
        }
        public void setAddress(String address) {
            this.address = address;
        }
        public String getAddress() {
            return this.address;
        }
        public void setCovers(List<String> covers) {
            this.covers = covers;
        }
        public List<String> getCovers() {
            return covers;
        }

        public Object getId() {
            return this.policyHandle.toString();
        }

        @Override
        public Policy clone() {
            try {
                return (Policy)super.clone();
            } catch (CloneNotSupportedException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }

        @Override
        public String toString() {
            // this.covers.stream().forEach(cover -> cover.toString());
            return "PolicyHandle: " + this.policyHandle.toString() + "@Covers: " + this.covers.size() + "@Address: " + this.address;
        }
    }

    private static class Person implements HasId, Cloneable
    {
        long id;
        String first;
        String last;

        public Object getId()
        {
            return id;
        }
        @Override
        public Person clone() {
            try {
                return (Person)super.clone();
            } catch (CloneNotSupportedException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
    }

    @Test
    public void testSimpleObjectDifference() throws Exception {
        // Person p1 = new Person();
        // p1.id = 111L;
        // p1.first = "John";
        // p1.last = "DeRegnaucourt";

        /**
         * SUBS ---- E1 ---- E2
         * SUBS ---- E1 ---- E3 ---- E2
         * Compare E1 - E2
         * Compare E1 - E3
         * Apply E3 into E1
         * Apply E2 into E3
         */

        Policy subscription = new Policy("A001", "0001", "0001");
        
        // In endorsement 1 we add one cover
        Policy endorsement1 = new Policy("A001", "0002", "0001");
        endorsement1.getCovers().add("Cover Endorsement 1");
        System.out.println("Endorsement 1 -> " + endorsement1.toString());
        // In endorsement 2 we add another cover
        Policy endorsement2 = new Policy("A001", "0003", "0001");
        endorsement2.getCovers().add("Cover Endorsement 1");
        endorsement2.getCovers().add("Cover Endorsement 2");
        System.out.println("Endorsement 2 -> " + endorsement2.toString());
        // In endorsement 3 (retro) we change the address
        Policy endorsement3 = new Policy("A001", "0004", "0001");
        endorsement3.getCovers().add("Cover Endorsement 1");
        endorsement3.setAddress("New Address");
        System.out.println("Endorsement 3 -> " + endorsement3.toString());

        // Person p2 = (Person) p1.clone();

        // long id = p1.id;
        // p2.first = "Jack";
        // assertFalse(DeepEquals.deepEquals(p1, p2));

        assertFalse(DeepEquals.deepEquals(endorsement1, endorsement2));
        assertFalse(DeepEquals.deepEquals(endorsement2, endorsement3));
        assertFalse(DeepEquals.deepEquals(endorsement1, endorsement3));

        // PolicyHandle tmp = endorsement2.getPolicyHandle();
        // endorsement2.setPolicyHandle(endorsement1.getPolicyHandle());
        List<Delta> diffE1E2 = GraphComparator.compare(endorsement1, endorsement2, getIdFetcher());
        System.out.println(diffE1E2);
        // endorsement2.setPolicyHandle(tmp);
        // assertTrue(diffE1E2.size() == 1);

        List<Delta> diffE1E3 = GraphComparator.compare(endorsement1, endorsement3, getIdFetcher());
        System.out.println(diffE1E3);

        GraphComparator.applyDelta(endorsement1, diffE1E3, getIdFetcher(), GraphComparator.getJavaDeltaProcessor());
        System.out.println("Endorsement 1 + 3 -> " + endorsement1.toString());
        GraphComparator.applyDelta(endorsement1, diffE1E2, getIdFetcher(), GraphComparator.getJavaDeltaProcessor());
        System.out.println("Endorsement 1 + 2 -> " + endorsement1.toString());

        // List<GraphComparator.Delta> deltas = GraphComparator.compare(p1, p2, getIdFetcher());
        // assertTrue(deltas.size() == 1);
        // GraphComparator.Delta delta = deltas.get(0);
        // // assertTrue(OBJECT_ASSIGN_FIELD == delta.getCmd());
        // assertTrue("first".equals(delta.getFieldName()));
        // assertNull(delta.getOptionalKey());
        // assertTrue("John".equals(delta.getSourceValue()));
        // assertTrue("Jack".equals(delta.getTargetValue()));
        // assertTrue((Long) delta.getId() == id);

        // GraphComparator.applyDelta(p1, deltas, getIdFetcher(), GraphComparator.getJavaDeltaProcessor());
        // assertTrue(DeepEquals.deepEquals(p1, p2));
    }
}
