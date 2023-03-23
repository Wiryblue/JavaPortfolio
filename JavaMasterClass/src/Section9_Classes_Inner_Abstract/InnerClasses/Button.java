package Section9_Classes_Inner_Abstract.InnerClasses;

public class Button {

    private String title;
    private OnClickListener onClickListener;

    public Button(String title) {
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public void setOnClickListener(OnClickListener onClickListener){
        this.onClickListener = onClickListener;

    }

    public interface OnClickListener{
        public void onClick(String title);
    }
}
