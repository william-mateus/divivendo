package br.com.willaimsilva.testecheckbox

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.willaimsilva.testecheckbox.databinding.FragmentMediaBinding
import com.google.android.material.snackbar.Snackbar

class MediaFragment : Fragment() {

    private lateinit var binding: FragmentMediaBinding
    private lateinit var alertDialog: AlertDialog.Builder
    private fun validarCampo(piranha: String?): Boolean {
        return piranha.isNullOrEmpty() || piranha.toFloatOrNull() == null
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMediaBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.media.setOnClickListener{

            if (validarCampo(binding.mes1.text.toString())){
                Snackbar.make(it,"preencha todos os campos",Snackbar.LENGTH_SHORT).show()
            }
            else{

                val mes1 = binding.mes1.text.toString().toFloat()
                val mes2 = binding.mes2.text.toString().toFloat()
                val mes3 = binding.mes3.text.toString().toFloat()

                val media = mes1+mes2+mes3 /3

                Snackbar.make(it,"sua media para este gasto é de:R$ $media",Snackbar.LENGTH_LONG).show()

            }
        }

        binding.help.setOnClickListener {
            alertDialog = AlertDialog.Builder(view.context)
            alertDialog.setTitle(R.string.title)
            alertDialog.setMessage(R.string.btnHelp)
            alertDialog.setPositiveButton("ok"){dialog,_ ->
                dialog.dismiss()
            }
            alertDialog.show()
        }

    }
}

