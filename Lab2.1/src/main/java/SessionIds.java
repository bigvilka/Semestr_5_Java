import java.util.ArrayList;
import java.util.List;

public class SessionIds {
    private List<String> SessionIds;

    private static SessionIds instance;

    private SessionIds()
    {
        SessionIds = new ArrayList<String>();
    }

    public static SessionIds getInstance()
    {
        if (instance == null)
        {
            instance = new SessionIds();
        }

        return instance;
    }

    public void Add(String value)
    {
        SessionIds.add(value);
    }

    public boolean Contains(String value)
    {
        return SessionIds.contains(value);
    }
}
