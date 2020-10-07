package com.example.firstco.TestApi

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firstco.R


class UserAdapter(private val list: java.util.List<User>?) : RecyclerView.Adapter<ViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater:LayoutInflater = LayoutInflater.from(parent.context)

        return ViewHolder(layoutInflater,parent )
    }

    override fun getItemCount(): Int {

        return this.list!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        list?.get(position)?.let { holder.bind(it) }
    }





}

class ViewHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_user, parent, false)) {
    private var id: TextView? = null
    private var name: TextView? = null
    private var lastname: TextView? = null
    private var email: TextView? = null


    init{
        id = itemView.findViewById(R.id.id)
        name = itemView.findViewById(R.id.name)
        lastname = itemView.findViewById(R.id.lastname)
        email = itemView.findViewById(R.id.email)
    }

    fun bind(user: User) {
        id?.text = ""+user.id
        name?.text = user.first_name
        lastname?.text = user.last_name
        email?.text = user.email
    }

}
