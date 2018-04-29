// package es.edu.java.compare;

// import java.lang.reflect.Field;
// import java.lang.reflect.Field;
// import java.util.Collection;
// import java.util.LinkedList;
// import java.util.Set;

// import es.edu.java.utils.GraphComparator;
// import es.edu.java.utils.ReflectionUtils;

// import static es.edu.java.utils.GraphComparator.Delta.Command.ARRAY_RESIZE;
// import static es.edu.java.utils.GraphComparator.Delta.Command.ARRAY_SET_ELEMENT;
// import static es.edu.java.utils.GraphComparator.Delta.Command.LIST_RESIZE;
// import static es.edu.java.utils.GraphComparator.Delta.Command.LIST_SET_ELEMENT;
// import static es.edu.java.utils.GraphComparator.Delta.Command.MAP_PUT;
// import static es.edu.java.utils.GraphComparator.Delta.Command.MAP_REMOVE;
// import static es.edu.java.utils.GraphComparator.Delta.Command.OBJECT_ASSIGN_FIELD;
// import static es.edu.java.utils.GraphComparator.Delta.Command.OBJECT_FIELD_TYPE_CHANGED;
// import static es.edu.java.utils.GraphComparator.Delta.Command.OBJECT_ORPHAN;
// import static es.edu.java.utils.GraphComparator.Delta.Command.SET_ADD;
// import static es.edu.java.utils.GraphComparator.Delta.Command.SET_REMOVE;

// public class CustomGraphComparator extends GraphComparator {
//     // @Override
//     public static void compareObjects(Delta delta, Set<Delta> deltas, LinkedList<Delta> stack, ID idFetcher) {
//         final Object srcValue = delta.getSourceValue();
//         final Object targetValue = delta.getTargetValue();

//         final Object srcId = idFetcher.getId(srcValue);
//         final Object targetId = idFetcher.getId(targetValue);

//         if (!srcId.equals(targetId))
//         {   // Field references different object, need to create a command that assigns the new object to the field.
//             // This maintains 'Graph Shape'
//             delta.setCmd(OBJECT_ASSIGN_FIELD);
//             deltas.add(delta);
//             // continue;
//             return;
//         }

//         final Collection<Field> fields = ReflectionUtils.getDeepDeclaredFields(srcValue.getClass());
//         String sysId = "(" + System.identityHashCode(srcValue) + ").";

//         for (Field field : fields)
//         {
//             try
//             {
//                 String srcPtr = sysId + field.getName();
//                 stack.push(new Delta(srcId, field.getName(), srcPtr, field.get(srcValue), field.get(targetValue), null));
//             }
//             catch (Exception ignored) { }
//         }
//     }
// }