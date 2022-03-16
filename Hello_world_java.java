public class Noncompliant extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // The intent used to start this exported component is retrieved
        Intent intent = getIntent();

        // extract the embedded Intent
        Intent forward = (Intent) intent.getParcelableExtra("anotherintent");

        // redirect the embedded Intent
        startActivity(forward); // Noncompliant
    }
}
