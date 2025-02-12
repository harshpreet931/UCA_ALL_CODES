import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Path_with_min_cost_src_to_dest_sir {
    
    class Main {
        public static void main(String[] args) {
        List<List<Integer>> stops = new ArrayList<>();
            stops.add(Arrays.asList(0 , 1, 100));
            stops.add(Arrays.asList(0 , 2, 100));
            stops.add(Arrays.asList(1 , 3, 500));
            stops.add(Arrays.asList(2 , 3, 1000));
            stops.add(Arrays.asList(3 , 4, 100));
            stops.add(Arrays.asList(2 , 4, 10000));
            
            
            Comparator<int[]> timeComparator = (p1, p2) -> {
            if (p1[0] != p2[0]) return Integer.compare(p1[0], p2[0]);
            return Integer.compare(p1[1], p2[1]);
            };
            
            Comparator<int[]> priceComparator = (p1, p2) -> {
            if (p1[1] != p2[1]) return Integer.compare(p1[1], p2[1]);
            return Integer.compare(p1[0], p2[0]);
            };
            
            
            CityRouter cityRouter = new CityRouter(5, stops, timeComparator);
            System.out.println(cityRouter.getBestRoute(0,4));
            CityRouter cityRouter2 = new CityRouter(5, stops, priceComparator);
            System.out.println(cityRouter2.getBestRoute(0,4));
            
    }
    }

    static class CustomerCost {
        int price;
        int time;
        
        CustomerCost(int time, int price) {
            this.time = time;
            this.price = price;
        }
        
        public String toString() {
            return "Price : " + this.price + "  Time : " + this.time;
        }
    }

    // implement this first.
    interface RouteTracker {
        public CustomerCost getBestRoute(int src, int dest);
    }

    static class CityRouter implements RouteTracker {
        
        Map<Integer, List<int[]>> cityMap;
        int totalStops;
        Comparator<int[]> customComparator;
        
        CityRouter(int n, List<List<Integer>> stops, Comparator<int[]> customComparator) {
            totalStops = n;
            cityMap = new HashMap<>();
            this.customComparator = customComparator;
            
            for (int i = 0; i < stops.size(); i++) {
                int src = stops.get(i).get(0);
                int dest = stops.get(i).get(1);
                int price = stops.get(i).get(2);
                List<int[]> srcAdj = cityMap.getOrDefault(src, new ArrayList<>());
                srcAdj.add(new int[] {dest, price});
                cityMap.put(src, srcAdj);
            }
        }
        
        public CustomerCost getBestRoute(int src, int dest) {
            CustomerCost allStopCost[] = new CustomerCost[totalStops];
            PriorityQueue<int[]> heap = new PriorityQueue<int[]>(customComparator);
            
            heap.add(new int[] {src, 0, 0});
            
            while(!heap.isEmpty()) {
                int[] currStop = heap.poll();
                
                if (allStopCost[currStop[0]] != null) {
                if (customComparator.compare(new int[] {allStopCost[currStop[0]].time, allStopCost[currStop[0]].price},
                                            new int[] {currStop[1], currStop[2]}) <= 0) {
                    continue;  
                }
                }
                allStopCost[currStop[0]] = new CustomerCost(currStop[1], currStop[2]);
                
                for (int[] nextStop : cityMap.getOrDefault(currStop[0], new ArrayList<>())) {
                heap.add(new int[] {nextStop[0], currStop[1] + 30, currStop[2] + nextStop[1]});
                }
            }
            
            return allStopCost[dest];
        }
    }
}
